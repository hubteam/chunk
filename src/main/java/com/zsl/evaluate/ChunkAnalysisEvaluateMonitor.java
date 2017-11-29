package com.zsl.evaluate;

import com.zsl.stream.ChunkAnalysisSample;

import opennlp.tools.util.eval.EvaluationMonitor;

/**
 * 检测类
 * @author 王馨苇
 *
 */
public class ChunkAnalysisEvaluateMonitor implements EvaluationMonitor<ChunkAnalysisSample>{

	/**
	 * 预测正确的时候执行
	 * @param arg0 参考的结果
	 * @param arg1 预测的结果
	 */
	@Override
	public void correctlyClassified(ChunkAnalysisSample arg0, ChunkAnalysisSample arg1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 预测正确的时候执行
	 * @param arg0 参考的结果
	 * @param arg1 预测的结果
	 */
	@Override
	public void missclassified(ChunkAnalysisSample arg0, ChunkAnalysisSample arg1) {
		// TODO Auto-generated method stub
		
	}

}
