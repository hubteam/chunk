package com.zsl.evaluate;

import java.io.OutputStream;
import java.io.PrintStream;

import com.zsl.stream.ChunkAnalysisSample;

/**
 * 错误样本输出
 * @author 王馨苇
 *
 */
public class ChunkAnalysisErrorPrinter extends ChunkAnalysisEvaluateMonitor{
	private PrintStream errOut;
	
	public ChunkAnalysisErrorPrinter(OutputStream out){
		errOut = new PrintStream(out);
	}
	
	/**
	 * 样本和预测的不一样的时候进行输出
	 * @param reference 参考的样本
	 * @param predict 预测的结果
	 */
	@Override
	public void missclassified(ChunkAnalysisSample reference, ChunkAnalysisSample predict) {
		 errOut.println("样本的结果：");
		 
		 errOut.println();
		 errOut.println("预测的结果：");
		
		 errOut.println();
	}
}
