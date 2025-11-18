const express = require('express');
const path = require('path');
const cors = require('cors');
const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/Meeting', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
})
    .then(() => console.log('Connected To Mongo Database'))
    .catch(err => console.error('MongoDB Connection Error:', err));

const workerSchema = new mongoose.Schema({
    name: String,
    roomNumber: String,
    uid: String,
    videoEnabled: { type: Boolean, default: true },
    audioEnabled: { type: Boolean, default: true },
    blocked: { type: Boolean, default: false },
    joinedAt: { type: Date, default: Date.now }
});

const Worker = mongoose.model('Worker', workerSchema);

const app = express();
const PORT = 10745;

app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname)));

app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'admin.html'));
});

app.post('/api/participants', async (req, res) => {
    try {
        const { name, roomNumber, uid } = req.body;
        if (!name || !roomNumber || !uid) {
            return res.status(400).json({ error: 'Name, Room Number, And UID Are Required' });
        }

        const newWorker = new Worker({ name, roomNumber, uid });
        await newWorker.save();
        res.status(201).json({ message: 'Participant Added Successfully', worker: newWorker });
    } catch (error) {
        console.error('Error Saving Participant:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

app.get('/api/participants', async (req, res) => {
    try {
        const participants = await Worker.find({});
        res.status(200).json(participants);
    } catch (error) {
        console.error('Error Fetching Participants:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


app.get('/api/participant/:uid', async (req, res) => {
    try {
        const participant = await Worker.findOne({ uid: req.params.uid });
        if (!participant) {
            return res.status(404).json({ error: 'Participant Not Found' });
        }
        res.status(200).json({ name: participant.name });
    } catch (error) {
        console.error('Error Fetching Participant:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

app.put('/api/participants/control', async (req, res) => {
    try {
        const { videoEnabled, audioEnabled } = req.body;

        if (videoEnabled !== undefined) {
            await Worker.updateMany({}, { videoEnabled });
        }
        if (audioEnabled !== undefined) {
            await Worker.updateMany({}, { audioEnabled });
        }

        res.status(200).json({ message: 'Control Updated Successfully' });
    } catch (error) {
        console.error('Error Updating Controls:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

app.delete('/api/participants/:uid', async (req, res) => {
    try {
        const result = await Worker.findOneAndDelete({ uid: req.params.uid });
        if (!result) {
            return res.status(404).json({ error: 'Participant Not Found' });
        }

        res.status(200).json({ message: 'Participant Removed Successfully' });
    } catch (error) {
        console.error('Error Removing Participant:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

app.put('/api/participants/kick/:uid', async (req, res) => {
    try {
        const result = await Worker.findOneAndDelete({ uid: req.params.uid });
        if (!result) {
            return res.status(404).json({ error: 'Participant Not Found' });
        }

        res.status(200).json({ message: 'Participant Kicked Successfully' });
    } catch (error) {
        console.error('Error Kicking Participant:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

app.put('/api/participants/block/:uid', async (req, res) => {
    try {
        const participant = await Worker.findOne({ uid: req.params.uid });
        if (!participant) {
            return res.status(404).json({ error: 'Participant Not Found' });
        }

        participant.blocked = true;
        await participant.save();

        res.status(200).json({ message: 'Participant Blocked Successfully' });
    } catch (error) {
        console.error('Error Blocking Participant:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

console.log("This Has Digital Rights");
console.log("Developer - Amulya Shrivastava");

app.listen(PORT, () => {
    console.log(`Server Is Running On http://localhost:${PORT}`);
});