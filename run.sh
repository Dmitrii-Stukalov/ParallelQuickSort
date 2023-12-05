validate='false'

print_usage() {
  printf "Usage: ./run.sh -v"
}

while getopts 'v' flag; do
  case "${flag}" in
    v) validate='true' ;;
    *) print_usage
       exit 1 ;;
  esac
done

javac -cp src -encoding utf8 -d ./bin ./src/Main.java && java -cp ./bin Main ${validate}
