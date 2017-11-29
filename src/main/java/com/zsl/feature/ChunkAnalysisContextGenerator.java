package com.zsl.feature;

/**
 * 生成特征的接口
 * @author 王馨苇
 *
 */
public interface ChunkAnalysisContextGenerator extends BeamSearchChunkAnalysisContextGenerator<String>{

	/**
	 * 特征生成方法
	 * @param i 当前位置
	 * @param words 词语序列
 	 * @param poses 词性标记
	 * @param chunktag chunk标记
	 * @param ac
	 * @return
	 */
	String[] getContext(int i, String[] words, String[] poses, String[] chunktag, Object[] ac);
}
