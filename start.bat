@echo off
setlocal
if not exist paper.jar (
  echo [ERROR] paper.jar not found. Place Paper 1.16.5 as paper.jar in this folder.
  pause
  exit /b 1
)
java -Xms2G -Xmx6G -jar paper.jar nogui
pause
