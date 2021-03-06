package com.zsl.beamsearch;

import com.zsl.feature.BeamSearchChunkAnalysisContextGenerator;

import opennlp.tools.util.Sequence;

/**
 * 得到结果序列的接口
 * @author 王馨苇
 *
 * @param <T> 模板
 */
public interface ChunkAnalysisSequenceClassificationModel<T> {
	/**
	 * 得到最好的序列
	 * @param arg0 词语
	 * @param arg1 词性
	 * @param arg3 额外的信息
	 * @param arg4 上下文生成器
	 * @param arg5 序列的验证器
	 * @return 最好的序列
	 */
	Sequence bestSequence(T[] arg0, T[] arg1, Object[] arg3, BeamSearchChunkAnalysisContextGenerator<T> arg4, ChunkAnalysisSequenceValidator<T> arg5) ;

	/**
	 * 得到最好的arg0个序列
	 * @param arg0 最好的几个序列
	 * @param arg1 词语
	 * @param arg2 词性
	 * @param arg4 额外的信息
	 * @param arg5 标记所得最小的分数的限制
	 * @param arg6 上下文生成器
	 * @param arg7 序列的验证器
	 * @return
	 */
	Sequence[] bestSequences(int arg0, T[] arg1, T[] arg2, Object[] arg4, double arg5, BeamSearchChunkAnalysisContextGenerator<T> arg6,
			ChunkAnalysisSequenceValidator<T> arg7);

	/**
	 * 得到最好的arg0个序列
	 * @param arg0 最好的几个序列
	 * @param arg1 词语
	 * @param arg2 词性
	 * @param arg4 额外的信息
	 * @param arg5 上下文生成器
	 * @param arg6 序列的验证器
	 * @return
	 */
	Sequence[] bestSequences(int arg0, T[] arg1, T[] arg2, Object[] arg4, BeamSearchChunkAnalysisContextGenerator<T> arg5,
			ChunkAnalysisSequenceValidator<T> arg6);
	
	/**
	 * 得到最好的结果
	 * @return
	 */
	String[] getOutcomes();
}

