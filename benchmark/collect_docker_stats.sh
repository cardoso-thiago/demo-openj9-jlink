trap printout SIGINT
printout() {
    cat data.csv
    rm -rf dockerstats
    exit
}
rm -rf data.csv
echo "NAME;CPU %;MEM %;MEM USAGE / LIMIT;NET I/O;BLOCK I/O;PIDS" >> data.csv
while :
do
    docker stats --no-stream --format "table {{.Name}};{{.CPUPerc}};{{.MemPerc}};{{.MemUsage}};{{.NetIO}};{{.BlockIO}};{{.PIDs}}" | tail -n +2 >> data.csv
    sleep 5
done