package com.zsl.cv;

import java.io.IOException;

import com.wxw.ner.evaluate.NERMeasure;
import com.wxw.ner.evaluate.NERWordAndPosEvaluateMonitor;
import com.wxw.ner.evaluate.NERWordAndPosEvaluator;
import com.wxw.ner.sample.NERWordAndPosSample;
import com.wxw.ner.wordandpos.feature.NERWordAndPosContextGenerator;
import com.wxw.ner.wordandpos.model.NERWordAndPosME;
import com.wxw.ner.wordandpos.model.NERWordAndPosModel;
import com.zsl.evaluate.ChunkAnalysisEvaluateMonitor;
import com.zsl.evaluate.ChunkAnalysisEvaluator;
import com.zsl.evaluate.ChunkAnalysisMeasure;
import com.zsl.feature.ChunkAnalysisContextGenerator;
import com.zsl.model.ChunkAnalysisME;
import com.zsl.model.ChunkAnalysisModel;
import com.zsl.stream.ChunkAnalysisSample;

import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;

/**
 * 交叉验证
 * @author 王馨苇
 *
 */
public class ChunkAnalysisCrossValidation {

	private final String languageCode;
	private final TrainingParameters params;
	private ChunkAnalysisEvaluateMonitor[] monitor;
	
	/**
	 * 构造
	 * @param languageCode 编码格式
	 * @param params 训练的参数
	 * @param listeners 监听器
	 */
	public ChunkAnalysisCrossValidation(String languageCode,TrainingParameters params,ChunkAnalysisEvaluateMonitor... monitor){
		this.languageCode = languageCode;
		this.params = params;
		this.monitor = monitor;
	}
	
	/**
	 * 交叉验证十折评估
	 * @param sample 样本流
	 * @param nFolds 折数
	 * @param contextGenerator 上下文
	 * @throws IOException io异常
	 */
	public void evaluate(ObjectStream<ChunkAnalysisSample> sample, int nFolds,
			ChunkAnalysisContextGenerator contextGenerator) throws IOException{
		CrossValidationPartitioner<ChunkAnalysisSample> partitioner = new CrossValidationPartitioner<ChunkAnalysisSample>(sample, nFolds);
		
		int run = 1;
		//小于折数的时候
		while(partitioner.hasNext()){
			System.out.println("Run"+run+"...");
			CrossValidationPartitioner.TrainingSampleStream<ChunkAnalysisSample> trainingSampleStream = partitioner.next();

			ChunkAnalysisModel model = ChunkAnalysisME.train(languageCode, trainingSampleStream, params, contextGenerator);

			ChunkAnalysisEvaluator evaluator = new ChunkAnalysisEvaluator(new ChunkAnalysisME(model, contextGenerator), monitor);
			ChunkAnalysisMeasure measure = new ChunkAnalysisMeasure();
			
			evaluator.setMeasure(measure);
	        //设置测试集（在测试集上进行评价）
	        evaluator.evaluate(trainingSampleStream.getTestSampleStream());
	        
	        System.out.println(measure);
	        run++;
		}
//		System.out.println(measure);
	}
}
