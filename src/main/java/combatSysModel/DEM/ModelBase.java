package combatSysModel.DEM;

public abstract class ModelBase {
    IDEVSModel _dem;

    public ModelBase(IDEVSModel _dem){
        this._dem = _dem;
        this._dem.constructModel();
    }

}
