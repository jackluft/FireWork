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
To run the program first build the docker image with the command: ```docker build -t <imageName> .``` <br>
After creating the image, run it with the command: ```xhost + && docker run -it --rm -e DISPLAY=host.docker.internal:0 -v /tmp/.X11-unix:/tmp/.X11-unix <imageName>```

