FROM ubuntu:22.04

RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    openjfx \
    xvfb \
    x11-apps \
    xauth \
    libgtk-3-0 \
    libgconf-2-4 \
    libnss3 \
    libasound2 \
    libxss1 \
    libxtst6 \
    libxext6 \
    libxrender1 \
    libxi6 \
    libgl1-mesa-glx \
    libgl1-mesa-dri \
    fonts-liberation \
    xfonts-base \
    fontconfig \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY . /app

RUN javac --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml *.java


CMD Xvfb $DISPLAY -screen 0 1024x768x24 -ac +extension GLX +render -noreset & \
    java -Dprism.order=sw -Djavafx.platform=gtk --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml Window

