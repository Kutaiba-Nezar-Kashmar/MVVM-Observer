package tasklist.model;

public interface DataModel {

    String getLastUpdateTimeStamp();
    void increaseNumberOfUpdates();
    int getNumberOfUpdates();
    void increaseNumberOfRecalculateDataCounter();
    int getNumberOfRecalculateData();
}
