package com.cabbiemagnet.dao.mapper;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:45:24 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao.mapper	
 * @filename DateAdapter.java
 * @description 
 * ================================================================================
 */
public class DateAdapter extends XmlAdapter<String, Timestamp> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Timestamp v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public Timestamp unmarshal(String v) throws Exception {
        return (Timestamp) dateFormat.parse(v);
    }

}
