package asw.soa._DEM.coupledModel;

import asw.soa.data.ModelData;
import asw.soa._DEM.atomicModel.*;
import asw.soa._DEM.inportPort.In_ENV_INFO;
import asw.soa._DEM.outportPort.Out_ENT_INFO;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;

public class Submarine extends CoupledModel<Double, Double, SimTimeDouble> {

    public In_ENV_INFO in_ENV_INFO;
    public Out_ENT_INFO out_ENT_INFO;

    private Sensor s;
    private Maneuver m;
    private Controller c;

    public Submarine(String modelName, CoupledModel<Double, Double, SimTimeDouble> parentModel) {
        super(modelName, parentModel);

    }

    public void initialize(ModelData data) {

        s = new Sensor(data.name + "_sensor", this, data.detectRange);
        s.initialize(0.0);
        c = new Controller(data.name + "_controller", this);
        c.initialize(0.0);
        m = new Maneuver(data.name + "_maneuver", this, data);
        m.initialize(0.0);


        in_ENV_INFO = new In_ENV_INFO(this);
        out_ENT_INFO = new Out_ENT_INFO(this);

        this.addExternalInputCoupling(this.in_ENV_INFO, s.in_THREAT_ENT_INFO);

        this.addInternalCoupling(m.out_MOVE_RESULT, s.in_MOVE_RESULT);
        this.addInternalCoupling(m.out_MOVE_RESULT, c.in_MOVE_RESULT);
        this.addInternalCoupling(s.out_THREAT_INFO, c.in_THREAT_INFO);
        this.addInternalCoupling(c.out_MOVE_CMD, m.in_MOVE_CMD);

        this.addExternalOutputCoupling(m.out_MOVE_RESULT, this.out_ENT_INFO);
    }
}
