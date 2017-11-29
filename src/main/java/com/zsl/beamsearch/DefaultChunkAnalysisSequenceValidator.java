package com.zsl.beamsearch;

/**
 * 验证实现类
 * @author 王馨苇
 *
 */
public class DefaultChunkAnalysisSequenceValidator implements ChunkAnalysisSequenceValidator<String>{

	/**
	 * 验证序列是否正确
	 * @param i 当前词语下标
	 * @param words 词语
	 * @param poses 词性
	 * @param tags 语块标记
	 * @param out 得到的下一个字符的输出结果
	 */
	@Override
	public boolean validSequence(int i, String[] words, String[] poses, String[] tags, String out) {
		// TODO Auto-generated method stub
		return false;
	}

}
