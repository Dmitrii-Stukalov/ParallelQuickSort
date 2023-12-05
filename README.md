# Parallel quick sort
Implementation of parallel quick sort and comparison with sequential realization

## Run
To default run shell script is available: 
```shell
./run.sh
```
Also, there is validation check available, to enable it run script with flag -v:
```shell
./run.sh -v
```

## Results

| Algorithm  | Run 1  | Run 2  | Run 3  | Run 4  | Run 5  | Avg    |
|------------|--------|--------|--------|--------|--------|--------|
| Parallel   | 2279ms | 2387ms | 2258ms | 2390ms | 2769ms | 2416ms |
| Sequential | 9374ms | 9306ms | 9254ms | 9286ms | 9424ms | 9328ms |
| Library    | 6983ms | 6894ms | 6931ms | 7014ms | 6919ms | 6948ms |

### Acceleration coefficient:
* Sequential / Parallel ~ 3.86
* Library / Parallel ~ 2.88