
package oving8;
 
import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
 
public class Asteroids extends Pane implements EventHandler<KeyEvent>  {
 
    private List<SpaceObject> spaceObjects;
     
    protected void add(SpaceObject so, double x, double y) {
        so.translate(x, y);
        getChildren().add(so);
        spaceObjects.add(so);
    }
    public void init() {
        spaceObjects = new ArrayList<SpaceObject>();
    }
 
    public void run() {
        // setter opp simuleringstakt
        Timeline tickTimer = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            private int tickCount = 0;
            @Override
            public void handle(ActionEvent event) {
                tick(tickCount++);
            }
        }));
        tickTimer.setCycleCount(Timeline.INDEFINITE);
        tickTimer.play();
        requestFocus();
        setOnKeyPressed(this);
        setOnKeyTyped(this);
    }
 
    // kalles n?r spesialtaster som pilene trykkes
    protected void handleKey(KeyCode keyCode) {
    }
 
    // kalles n?r vanlige bokstavtaster trykkes
    protected void handleKey(String character) {
        if ("+".equals(character)) {
            zoom(2);
        } else if ("-".equals(character)) {
            zoom(0.5);
        }
    }
     
    private void zoom(double factor) {
        setScaleX(getScaleX() * factor);
        setScaleY(getScaleY() * factor);
    }
     
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UNDEFINED) {
            handleKey(keyEvent.getCharacter());
        } else {
            handleKey(keyEvent.getCode());
        }
    }
 
    private void tick(int tickCount) {
        // accelerate due to gravity
 
        // lag en (dobbel) l?kke her, som
        // h?ndterer gravitasjonskraften for alle par i spaceObjects-lista 
 
        // move all objects
        for (SpaceObject spaceObject : spaceObjects) {
            spaceObject.tick();
        }
 
        // check for collision
        // lag en (dobbel) l?kke her, som
        // sjekker for og h?ndterer kollisjoner for alle par i spaceObjects-lista
    }
 
    public void handleGravity(SpaceObject spaceObject1, SpaceObject spaceObject2) {
        // regn ut avstanden mellom spaceObject1 og spaceObject2 (bruk getCenter-metoden),
        // beregn den gjensidige gravitasjonskraften basert p? formelen
        // masse1 * masse2 / avstand ^ 2, og
        // p?f?r kraften med SpaceObject.applyForce-metoden
    }
}
