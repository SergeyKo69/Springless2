package ru.kogut.components;

import org.springframework.stereotype.Component;
import ru.kogut.annotation.UnproducableCameraRoll;

@Component("cameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = BlackAndWhiteCameraRoll.class)
public class ColorCameraRoll implements CameraRoll {

    public void processing() {

        // TODO Auto-generated method stub
        System.out.println("-1 цветной кадр");

    }

}
