# JavaFX Firework Docker Application 🎆

This project runs a **JavaFX firework application** inside a Docker container with GUI support. 

**Application behavior:**  
Whenever you click anywhere on the window screen, a colorful firework launches from the clicked position.

---

## Requirements

- **Docker**: Install Docker Engine on your machine.
- **XQuartz (macOS)**: Install [XQuartz](https://www.xquartz.org/) for X11 display support on macOS.
- **Linux X Server**: On Linux, ensure an X server is running (usually default).

---

## Run Program
To run the program first build the docker image with the command: <pre> ```docker build -t <imageName> . ``` </pre> <br>

After creating the image, run it with the command: <pre> ```xhost + && docker run -it --rm -e DISPLAY=host.docker.internal:0 -v /tmp/.X11-unix:/tmp/.X11-unix <imageName>``` </pre>
<br>
<br>
The `xhost` command manages access control for the X server (the graphical display system used on Unix/Linux).

### What does `xhost +` do?

- `xhost +` **disables all access control**, allowing **any host** to connect to your X server.
- This means **anyone on the network can display graphical windows on your screen**.

## Disclaimer

- This project **has not yet been tested on Windows OS**.
- If you want to run it on Windows, you will likely need to **change the `DISPLAY` environment variable** in the `docker run` command.
- For example, on Windows with Docker Desktop, try replacing:

  ```bash
  -e DISPLAY=host.docker.internal:0

