# Java Circuit Breaker

External services used

- Ok: https://run.mocky.io/v3/3b5cd73e-5508-4b1d-9bbe-83bcb3e6be54
- Error: https://run.mocky.io/v3/928b01ac-53c0-4b65-b730-edae6b530209


#### Information about the circuits
http://localhost:8080/actuator/health

- Successful call
```sh
curl 'http://localhost:8080/api/usecase/path?id=3b5cd73e-5508-4b1d-9bbe-83bcb3e6be54'
```

- Failed call
```sh
curl 'http://localhost:8080/api/usecase/path?id=928b01ac-53c0-4b65-b730-edae6b530209'
```

#### Run
```sh
gradle bootRun
```
