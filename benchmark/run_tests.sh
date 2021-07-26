count=1
while [ $count -le 1000 ]
do
  curl --location --request POST 'http://localhost:9090/user' \
  --header 'Content-Type: application/json' \
  --data-raw '{
    "name": "Thiago",
    "age": "66"
  }
  '
  printf "\n";
  count=$(( $count + 1 ))
done

fortio load -qps 950 -c 1000 -t 5m -a localhost:9090/user