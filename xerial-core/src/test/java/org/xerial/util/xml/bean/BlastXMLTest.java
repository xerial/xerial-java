//--------------------------------------
// XerialJ Project
//
// BlastXMLTest.java
// Since: 2005/08/04
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.bean;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.xerial.util.XMLParserException;
import org.xerial.util.xml.InvalidXMLException;
import org.xerial.util.xml.XMLGenerator;

import junit.framework.TestCase;

public class BlastXMLTest extends TestCase
{
    public void testBlastOutput() throws XMLParserException, XMLBeanException, InvalidXMLException, IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLGenerator xout = new XMLGenerator(out);

        xout.startTag("blastoutput");
        xout.startTag("blastoutput-iterations");
        xout.endTag();
        xout.endTag();
        xout.endDocument();
        xout.flush();
        
        InputStream in = new ByteArrayInputStream(out.toByteArray());
        BlastOutput bo = XMLBeanUtil.newInstance(BlastOutput.class, in);

        assertNotNull(bo);
        assertNotNull(bo.getBlastOutput_iterations());
    }
}




class BlastOutput {
    private String BlastOutput_program;
    private String BlastOutput_version;
    private String BlastOutput_reference;
    private String BlastOutput_db;
    private String BlastOutput_query_ID;
    private int BlastOutput_query_len;
    private BlastOutput_param blastOutput_param;
    private BlastOutput_iterations blastOutput_iterations;
    
    public String getBlastOutput_db() {
        return BlastOutput_db;
    }
    public void setBlastOutput_db(String blastOutput_db) {
        BlastOutput_db = blastOutput_db;
    }
    public String getBlastOutput_program() {
        return BlastOutput_program;
    }
    public void setBlastOutput_program(String blastOutput_program) {
        BlastOutput_program = blastOutput_program;
    }
    public String getBlastOutput_query_ID() {
        return BlastOutput_query_ID;
    }
    public void setBlastOutput_query_ID(String blastOutput_query_ID) {
        BlastOutput_query_ID = blastOutput_query_ID;
    }
    public int getBlastOutput_query_len() {
        return BlastOutput_query_len;
    }
    public void setBlastOutput_query_len(int blastOutput_query_len) {
        BlastOutput_query_len = blastOutput_query_len;
    }
    public String getBlastOutput_reference() {
        return BlastOutput_reference;
    }
    public void setBlastOutput_reference(String blastOutput_reference) {
        BlastOutput_reference = blastOutput_reference;
    }
    public String getBlastOutput_version() {
        return BlastOutput_version;
    }
    public void setBlastOutput_version(String blastOutput_version) {
        BlastOutput_version = blastOutput_version;
    }
    public BlastOutput_iterations getBlastOutput_iterations() {
        return blastOutput_iterations;
    }
    public Iteration getBlastOutput_iterations(int n) {
        if( n < 0 || n >= blastOutput_iterations.getIteration().length ) {
            // out of index
            return null;
        }
        return blastOutput_iterations.getIteration()[n];
    }
    public void setBlastOutput_iterations(
            BlastOutput_iterations blastOutput_iterations) {
        this.blastOutput_iterations = blastOutput_iterations;
    }
    public BlastOutput_param getBlastOutput_param() {
        return blastOutput_param;
    }
    public void setBlastOutput_param(BlastOutput_param blastOutput_param) {
        this.blastOutput_param = blastOutput_param;
    }

}

class BlastOutput_iterations {
    private Iteration[] iteration;

    public Iteration[] getIteration() {
        return iteration;
    }

    public void setIteration(Iteration[] iteration) {
        this.iteration = iteration;
    }
    
}

class Iteration {
    private int iteration_itr_num;
    private Iteration_hits iteration_hits;
    private Iteration_stat iteration_stat;
    
    public Iteration_hits getIteration_hits() {
        return iteration_hits;
    }
    public Hit getIteration_hits(int n) {
        if( n < 0 || n >= iteration_hits.getHit().length ) {
            // out of index
            return null;
        }
        return iteration_hits.getHit()[n];
    }
    public void setIteration_hits(Iteration_hits iteration_hits) {
        this.iteration_hits = iteration_hits;
    }
    public int getIteration_itr_num() {
        return iteration_itr_num;
    }
    public void setIteration_itr_num(int iteration_itr_num) {
        this.iteration_itr_num = iteration_itr_num;
    }
    public Iteration_stat getIteration_stat() {
        return iteration_stat;
    }
    public void setIteration_stat(Iteration_stat iteration_stat) {
        this.iteration_stat = iteration_stat;
    }

}

class Iteration_stat {
    private Statistics statistics;

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
    
    
}

class Statistics {
    private int statistics_db_num;
    private int statistics_db_len;
    private int statistics_hsp_len;
    private double statistics_eff_space;
    private double statistics_kappa;
    private double statistics_lambda;
    private double statistics_entropy;
    
    public int getStatistics_db_len() {
        return statistics_db_len;
    }
    public void setStatistics_db_len(int statistics_db_len) {
        this.statistics_db_len = statistics_db_len;
    }
    public int getStatistics_db_num() {
        return statistics_db_num;
    }
    public void setStatistics_db_num(int statistics_db_num) {
        this.statistics_db_num = statistics_db_num;
    }
    public double getStatistics_eff_space() {
        return statistics_eff_space;
    }
    public void setStatistics_eff_space(double statistics_eff_space) {
        this.statistics_eff_space = statistics_eff_space;
    }
    public double getStatistics_entropy() {
        return statistics_entropy;
    }
    public void setStatistics_entropy(double statistics_entropy) {
        this.statistics_entropy = statistics_entropy;
    }
    public int getStatistics_hsp_len() {
        return statistics_hsp_len;
    }
    public void setStatistics_hsp_len(int statistics_hsp_len) {
        this.statistics_hsp_len = statistics_hsp_len;
    }
    public double getStatistics_kappa() {
        return statistics_kappa;
    }
    public void setStatistics_kappa(double statistics_kappa) {
        this.statistics_kappa = statistics_kappa;
    }
    public double getStatistics_lambda() {
        return statistics_lambda;
    }
    public void setStatistics_lambda(double statistics_lambda) {
        this.statistics_lambda = statistics_lambda;
    }
    
    
}


class BlastOutput_param {
    private Parameters parameters;

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
    
}

class Parameters {
    private String parameters_expect;
    private String parameters_sc_match;
    private String parameters_sc_mismatch;
    private String parameters_gap_open;
    private String parameters_gap_extend;
    private String parameters_filter;
    
    public String getParameters_expect() {
        return parameters_expect;
    }
    public void setParameters_expect(String parameters_expect) {
        this.parameters_expect = parameters_expect;
    }
    public String getParameters_filter() {
        return parameters_filter;
    }
    public void setParameters_filter(String parameters_filter) {
        this.parameters_filter = parameters_filter;
    }
    public String getParameters_gap_extend() {
        return parameters_gap_extend;
    }
    public void setParameters_gap_extend(String parameters_gap_extend) {
        this.parameters_gap_extend = parameters_gap_extend;
    }
    public String getParameters_gap_open() {
        return parameters_gap_open;
    }
    public void setParameters_gap_open(String parameters_gap_open) {
        this.parameters_gap_open = parameters_gap_open;
    }
    public String getParameters_sc_match() {
        return parameters_sc_match;
    }
    public void setParameters_sc_match(String parameters_sc_match) {
        this.parameters_sc_match = parameters_sc_match;
    }
    public String getParameters_sc_mismatch() {
        return parameters_sc_mismatch;
    }
    public void setParameters_sc_mismatch(String parameters_sc_mismatch) {
        this.parameters_sc_mismatch = parameters_sc_mismatch;
    }

    
}

class Iteration_hits {
    private Hit[] hit;

    public Hit[] getHit() {
        return hit;
    }

    public void setHit(Hit[] hit) {
        this.hit = hit;
    }
    
}

class Hit {
    private String hit_num;
    private String hit_id;
    private String hit_def;
    private String hit_accession;
    private String hit_len;
    private Hit_hsps hit_hsps;
    
    public String getHit_accession() {
        return hit_accession;
    }
    public void setHit_accession(String hit_accession) {
        this.hit_accession = hit_accession;
    }
    public String getHit_def() {
        return hit_def;
    }
    public void setHit_def(String hit_def) {
        this.hit_def = hit_def;
    }
    public Hit_hsps getHit_hsps() {
        return hit_hsps;
    }
    public void setHit_hsps(Hit_hsps hit_hsps) {
        this.hit_hsps = hit_hsps;
    }
    public String getHit_id() {
        return hit_id;
    }
    public void setHit_id(String hit_id) {
        this.hit_id = hit_id;
    }
    public String getHit_len() {
        return hit_len;
    }
    public void setHit_len(String hit_len) {
        this.hit_len = hit_len;
    }
    public String getHit_num() {
        return hit_num;
    }
    public void setHit_num(String hit_num) {
        this.hit_num = hit_num;
    }
    
    
}


class Hit_hsps {
    private Hsp[] hsp;

    public Hsp[] getHsp() {
        return hsp;
    }

    public void setHsp(Hsp[] hsp) {
        this.hsp = hsp;
    }
    
}

class Hsp {
    private int hsp_num;
    private double hsp_bit_score;
    private int hsp_score;
    private double hsp_evalue;
    private int hsp_query_from;
    private int hsp_query_to;
    private int hsp_hit_from;
    private int hsp_hit_to;
    private int hsp_query_frame;
    private int hsp_hit_frame;
    private int hsp_identity;
    private int hsp_positive;
    private int hsp_align_len;
    private String hsp_qseq;
    private String hsp_hseq;
    private String hsp_midline;
    
    public int getHsp_align_len() {
        return hsp_align_len;
    }
    public void setHsp_align_len(int hsp_align_len) {
        this.hsp_align_len = hsp_align_len;
    }
    public double getHsp_bit_score() {
        return hsp_bit_score;
    }
    public void setHsp_bit_score(double hsp_bit_score) {
        this.hsp_bit_score = hsp_bit_score;
    }
    public double getHsp_evalue() {
        return hsp_evalue;
    }
    public void setHsp_evalue(double hsp_evalue) {
        this.hsp_evalue = hsp_evalue;
    }
    public int getHsp_hit_frame() {
        return hsp_hit_frame;
    }
    public void setHsp_hit_frame(int hsp_hit_frame) {
        this.hsp_hit_frame = hsp_hit_frame;
    }
    public int getHsp_hit_from() {
        return hsp_hit_from;
    }
    public void setHsp_hit_from(int hsp_hit_from) {
        this.hsp_hit_from = hsp_hit_from;
    }
    public int getHsp_hit_to() {
        return hsp_hit_to;
    }
    public void setHsp_hit_to(int hsp_hit_to) {
        this.hsp_hit_to = hsp_hit_to;
    }
    public String getHsp_hseq() {
        return hsp_hseq;
    }
    public void setHsp_hseq(String hsp_hseq) {
        this.hsp_hseq = hsp_hseq;
    }
    public int getHsp_identity() {
        return hsp_identity;
    }
    public void setHsp_identity(int hsp_identity) {
        this.hsp_identity = hsp_identity;
    }
    public String getHsp_midline() {
        return hsp_midline;
    }
    public void setHsp_midline(String hsp_midline) {
        this.hsp_midline = hsp_midline;
    }
    public int getHsp_num() {
        return hsp_num;
    }
    public void setHsp_num(int hsp_num) {
        this.hsp_num = hsp_num;
    }
    public int getHsp_positive() {
        return hsp_positive;
    }
    public void setHsp_positive(int hsp_positive) {
        this.hsp_positive = hsp_positive;
    }
    public String getHsp_qseq() {
        return hsp_qseq;
    }
    public void setHsp_qseq(String hsp_qseq) {
        this.hsp_qseq = hsp_qseq;
    }
    public int getHsp_query_frame() {
        return hsp_query_frame;
    }
    public void setHsp_query_frame(int hsp_query_frame) {
        this.hsp_query_frame = hsp_query_frame;
    }
    public int getHsp_query_from() {
        return hsp_query_from;
    }
    public void setHsp_query_from(int hsp_query_from) {
        this.hsp_query_from = hsp_query_from;
    }
    public int getHsp_query_to() {
        return hsp_query_to;
    }
    public void setHsp_query_to(int hsp_query_to) {
        this.hsp_query_to = hsp_query_to;
    }
    public int getHsp_score() {
        return hsp_score;
    }
    public void setHsp_score(int hsp_score) {
        this.hsp_score = hsp_score;
    }
    
}

