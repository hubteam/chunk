package com.zsl.feature;

/**
 * 生成特征的接口
 * @author 王馨苇
 *
 * @param <T>
 */
public interface BeamSearchChunkAnalysisContextGenerator<T> {

	/**
	 * 特征生成方法
	 * @param i 当前位置
	 * @param words 词语序列
 	 * @param poses 词性标记
	 * @param chunktag chunk标记
	 * @param ac
	 * @return
	 */
	String[] getContext(int i, T[] words, T[] poses, String[] chunktag, Object[] ac);
}
