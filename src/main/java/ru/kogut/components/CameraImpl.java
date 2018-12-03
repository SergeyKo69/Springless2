package ru.kogut.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.kogut.annotation.UnproducableCamera;

import javax.annotation.PostConstruct;

@Component("camera")
@UnproducableCamera(usingCameraClass = CameraImplModern.class)
public class CameraImpl implements Camera {

    @Autowired
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    @Value("Nikon")
    private String nameCamera;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }


    public boolean isBroken() {
        return broken;
    }

    public void breaking() {

        this.broken = true;
    }

    public String getNameCamera() {
        return nameCamera;
    }

    public void doPhotograph() {

        if (isBroken()) {

            System.out.println("Фотоаппарат сломан!");
            return;
        }
        System.out.println("Сделана фотография!");
        cameraRoll.processing();


    }

    @PostConstruct
    public void ready() {

        System.out.println("Фотоаппарат " + getNameCamera() + " готов к использованию!");

    }

}
