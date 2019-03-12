package combatSysModel.DEM.coupledModel;

import asw.soa.data.ModelData;
import combatSysModel.DEM.CoupledModelBase;
import combatSysModel.DEM.atomicModel.Environment_am;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;
import nl.tudelft.simulation.language.d3.CartesianPoint;

public class ASW_CM extends CoupledModelBase {


     Platform_cm fleet;
     Platform_cm submarine;
     Environment_am env;

    //private Actor_Maneuver_am f;


    public ASW_CM(String modelName) {
        super(modelName);

    }

    public ASW_CM(String modelName, TimeDouble parentModel) {
        super(modelName, parentModel);

    }

    public ASW_CM(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    @Override
    protected void constructPort() {
//        this.addInternalCoupling(fleet.out_move_result,env.in_move_result);
//        this.addInternalCoupling(submarine.out_move_result,env.in_move_result);
//        this.addInternalCoupling(env.out_env_info,fleet.in_env_info);
//        this.addInternalCoupling(env.out_env_info,submarine.in_env_info);

    }

    @Override
    protected void couplingComponent() {
//        f = new Actor_Maneuver_am("Fleet",this);
//        f.constructModel();
        fleet = new Platform_cm("Fleet",this);
//        ModelData f1Data = new ModelData("Fleet");
//        f1Data.origin = f1Data.destination = new CartesianPoint(-200, -50, 0);

        fleet.constructModel();
        //fleet.maneuver.actor.getOm().setModelData(f1Data);

//        submarine = new Platform_cm("Submarine",this);
//        submarine.constructModel();
//        ModelData s1Data = new ModelData("Submarine");
//        s1Data.origin = s1Data.destination = new CartesianPoint(200, 100, 0);
//        submarine.maneuver.actor.getOm().setModelData(s1Data);
//
//
//        env = new Environment_am("env",this);
//        env.constructModel();
    }
}
