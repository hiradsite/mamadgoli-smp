#!/usr/bin/env bash
if [ ! -f paper.jar ]; then
    echo "[ERROR] paper.jar not found. Place Paper 1.16.5 as paper.jar here."
    exit 1
fi

java -Xms512M -Xmx3G -jar paper.jar nogui
