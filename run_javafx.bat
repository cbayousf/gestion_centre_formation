@echo off
set PATH_TO_FX=C:\Users\HAMID\Downloads\openjfx-24.0.1_windows-x64_bin-sdk\javafx-sdk-24.0.1\lib
set PATH_TO_FX_DLLS=C:\Users\HAMID\Downloads\openjfx-24.0.1_windows-x64_bin-sdk\javafx-sdk-24.0.1\bin
set MAIN_CLASS=Main

java -Djava.library.path=%PATH_TO_FX_DLLS% -Dprism.order=sw --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -cp out %MAIN_CLASS%
pause
