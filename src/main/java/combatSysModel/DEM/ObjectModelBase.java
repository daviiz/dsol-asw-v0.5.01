package combatSysModel.DEM;

public class ObjectModelBase implements java.io.Serializable {

    /**
     * 消息是否有效,初始时为无效状态，
     */
    protected volatile boolean status = false;

    public void setStatusInvalid(){
        this.status = false;
    }

    public void setStatusValid(){
        this.status = false;
    }
}
