//--------------------------------------
// xerial-lens Project
//
// TupleIndexTest.java
// Since: 2010/11/19
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.lens.relation;

import org.junit.Test;
import org.xerial.lens.SilkLens;
import org.xerial.util.log.Logger;

public class TupleIndexTest
{
    private static Logger _logger = Logger.getLogger(TupleIndexTest.class);

    @Test
    public void tupleIndex() throws Exception {
        TupleIndex i = new TupleIndex(1);
        String s = SilkLens.toSilk(i);
        _logger.debug(s);
    }

}
