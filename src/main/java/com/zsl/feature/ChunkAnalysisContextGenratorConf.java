package com.zsl.feature;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 特征生成类
 * @author 王馨苇
 *
 */
public class ChunkAnalysisContextGenratorConf implements ChunkAnalysisContextGenerator{
	
	private boolean p0Set;
	private boolean w0Set;
	private boolean defaultSet;
	private boolean c_1Set;
	private boolean p_1Set;
	private boolean p_2Set;
	private boolean p1Set;
	private boolean p2Set;
	private boolean w_1Set;
	private boolean w_2Set;
	private boolean w1Set;
	private boolean w2Set;
	private boolean r0Set;
	private boolean r_1Set;
	private boolean r1Set;

	public ChunkAnalysisContextGenratorConf() throws IOException {
		Properties featureConf = new Properties();
        InputStream featureStream = ChunkAnalysisContextGenratorConf.class.getClassLoader().getResourceAsStream("com/zsl/run/feature.properties");
        featureConf.load(featureStream);
        
        init(featureConf);
	}
	
	/**
	 * 构造
	 * @param properties 配置文件
	 */
	public ChunkAnalysisContextGenratorConf(Properties properties){
        
        init(properties);
	}
	
	private void init(Properties config) {
		w_2Set = (config.getProperty("feature.w_2", "true").equals("true"));
        w_1Set = (config.getProperty("feature.w_1", "true").equals("true"));
        w0Set = (config.getProperty("feature.w0", "true").equals("true"));
        w1Set = (config.getProperty("feature.w1", "true").equals("true"));
        w2Set = (config.getProperty("feature.w2", "true").equals("true"));
        
        p_2Set = (config.getProperty("feature.p_2", "true").equals("true"));
        p_1Set = (config.getProperty("feature.p_1", "true").equals("true"));
        p0Set = (config.getProperty("feature.p0", "true").equals("true"));
        p1Set = (config.getProperty("feature.p1", "true").equals("true"));
        p2Set = (config.getProperty("feature.p2", "true").equals("true"));
        
        c_1Set = (config.getProperty("feature.c_1", "true").equals("true")); 
        r0Set = (config.getProperty("feature.r0", "true").equals("true"));
        r_1Set = (config.getProperty("feature.r_1", "true").equals("true"));
        r1Set = (config.getProperty("feature.r1", "true").equals("true"));
        defaultSet = (config.getProperty("feature.default", "true").equals("true"));
	}

	/**
	 * 特征生成方法
	 * @param i 当前位置
	 * @param words 词语序列
 	 * @param poses 词性标记
	 * @param chunktag chunk标记
	 * @param ac
	 * @return
	 */
	@Override
	public String[] getContext(int i, String[] words, String[] poses, String[] chunktag, Object[] ac) {
		return getContext(i,words,poses,chunktag);
	}

	/**
	 * 特征生成方法
	 * @param index 当前位置
	 * @param words 词语序列
 	 * @param poses 词性标记
	 * @param chunktag chunk标记
	 * @return
	 */
	private String[] getContext(int index, String[] words, String[] poses, String[] chunktag) {
		String w1, w2, w0, w_1, w_2, r0,r1,r_1;
        w1 = w2 = w0 = w_1 = w_2 = r0 = r1 = r_1 = null;
        String p1, p2, p0, p_1, p_2;
        p1 = p2 = p0 = p_1 = p_2 = null;
        String c_1 = null;
        
        List<String> features = new ArrayList<String>();
        w0 = words[index];
        p0 = poses[index];
        if (words.length > index + 1) {
            w1 = words[index + 1];
            p1 = poses[index + 1];
            if (words.length > index + 2) {
                w2 = words[index + 2];
                p2 = poses[index + 2];
            }
        }

        if (index - 1 >= 0) {
            w_1 = words[index - 1];
            p_1 = poses[index - 1];
            c_1 = chunktag[index - 1];
            if (index - 2 >= 0) {
                w_2 = words[index - 2];
                p_2 = poses[index - 2];
            }
        }
        if (w0Set) {
            features.add("w0=" + w0);
        }
        
        if(p0Set){
        	features.add("p0="+p0);
        }

        if (w_1 != null) {
            if (w_1Set) {
                features.add("w_1=" + w_1);
            }
            if(p_1Set){
            	features.add("p_1=" + p_1);
            }

            if (w_2 != null) {
                if (w_2Set) {
                    features.add("w_2=" + w_2);
                }
                if (p_2Set) {
                    features.add("p_2=" + p_2);
                }
            }
        }

        if (w1 != null) {
            if (w1Set) {
                features.add("w1=" + w1);
            }
            if (p1Set) {
                features.add("p1=" + p1);
            }
            if (w2 != null) {
                if (w2Set) {
                    features.add("w2=" + w2);
                }
                if (p2Set) {
                    features.add("p2=" + p2);
                }
            }
        }

        if(c_1 != null){
        	if (c_1Set) {
                features.add("c_1=" + c_1);
            }
        }

        //还差音节的部分
        
        String[] contexts = features.toArray(new String[features.size()]);

        return contexts;
	}

	@Override
	public String toString() {
		return "ChunkAnalysisContextGenratorConf{" + "w_2Set=" + w_2Set + ", w_1Set=" + w_1Set + 
                ", w0Set=" + w0Set + ", w1Set=" + w1Set + ", w2Set=" + w2Set + 
                ", r_1Set=" + r_1Set + ", r0Set=" + r0Set + 
                ", r1Set=" + r1Set + ", w1w2Set=" +
                ", c_1Set=" + c_1Set +               
                ", p_2Set=" + p_2Set + ", p_1Set=" + p_1Set + ", p0Set=" + p0Set + 
                ", p1Set=" + p1Set + ", p2Set=" + p2Set + 
                ", defaultSet=" + defaultSet + 
                '}';
	}
}
