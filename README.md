## Run tests in Browserstack
```bash
gradle clean test -DDeviceHost=browserstack
```
## Run tests in Selenoid
```bash
gradle clean test -DDeviceHost=selenoid
```
## Run tests in Emulator
```bash
gradle clean test -DDeviceHost=emulation
```
## Run tests on real device
```bash
gradle clean test -DDeviceHost=real
```