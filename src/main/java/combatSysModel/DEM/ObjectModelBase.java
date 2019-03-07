package combatSysModel.DEM;

public class ObjectModelBase implements java.io.Serializable {
    /**
     * 消息是否有效,初始时为无效状态，
     * AM只发送status==true的消息，
     * 发送的消息在OM业务函数最后需要reset为无效状态
     */
    public boolean status = false;

    public void resetStatus(){
        this.status = false;
    }
}
