if [ $# -ne 3 ]; then
  echo "Invalid input"
  exit 1
fi
op1=$1
operator=$2
op2=$3
if ! [[ "$op1" =~ ^[+-]?[0-9]*(\.[0-9]+)?$ ]] || ! [[ "$op2" =~ ^[+-]?[0-9]*(\.[0-9]+)?$ ]]; then
  echo "Invalid input"
  exit 1
fi
case "$operator" in
  "+" | "-" | "*" | "^" )
    result=$(echo "scale=4; $op1 $operator $op2" | bc -l)
    ;;
  "/" )
    if (( $(echo "$op2 == 0" | bc -l) )); then
      echo "Division by zero error"
      exit 1
    fi
    result=$(echo "scale=4; $op1 / $op2" | bc -l)
    ;;
  "%" )
    if [[ "$op1" =~ ^[0-9]+$ ]] && [[ "$op2" =~ ^[0-9]+$ ]]; then
      result=$(("$op1" % "$op2"))
    else
      echo "Invalid input (Modulo operator '%' typically requires integers)"
      exit 1
    fi
    ;;
  * )
    echo "Invalid input"
    exit 1
    ;;
esac
echo "$op1 $operator $op2 = $result"

