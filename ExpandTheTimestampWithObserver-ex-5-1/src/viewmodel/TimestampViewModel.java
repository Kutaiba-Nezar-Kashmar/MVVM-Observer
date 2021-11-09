package viewmodel;

import com.sun.prism.paint.Paint;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.DataModel;
import tasklist.model.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private DataModel model;

    private Property<Paint> property;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates=new SimpleStringProperty("0");
        ((PropertyChangeSubject) model).addPropertyChangeListener((PropertyChangeEvent evt) -> this.updateTimestamp());
        property = new SimpleObjectProperty<>();
    }

    public void updateTimestamp() {
        model.increaseNumberOfUpdates();
        Platform.runLater(() -> {
            updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
            numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
        });
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }

    public Property<Paint> fillProperty()
    {
        return property;
    }
}
