package report;

import java.io.PrintWriter;
import java.util.List;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

/* try {
			writer = createWriter(outputDirectory);
		}catch(IOException e) {
			System.err.println("Unable to create output file");
			e.printStackTrace();
			return;
		}
		startHtml(writer);
		writeReportTitle(reportTitle);
		generateSuiteSummaryReport(suites);
		generateMethodSummaryReport(suites);
		generateMethodDetailRepost(suites);
		endHtml(writer);
		writer.flush();
		writer.close();		
	}
	
	protected void generateMethodSummaryReport(List<ISuite> suites) {
		methodIndex= 0;
		startResultSummaryTable("methodOverview");
		int testIndex = 1;
		for(ISuite suite : suites) {
			if(suites.size()>=1) {
				titleRow(suite.getName(), 5);
			}
			Map<String, ISuiteResult> r = suite.getResults();
		}
		
	}

	protected PrintWriter createWriter(String outdir) throws IOException{
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, reportFileName))));
		
	}*/


public class TestNGCustomReportListener implements IReporter {

	PrintWriter writer;
	int row;
	Integer testIndex;
	int methodIndex;
	String reportTitle = "TestNG Customized Report";
	String reportFileName = "custom-report.html";
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		System.out.println(xmlSuites.size());
		for(ISuite suite : suites) {
			String suiteName = suite.getName();
			//Map<String, ISuiteResult> suiteResults = suite.getResults();
			for(ISuiteResult sr:suite.getResults().values()) {
				ITestContext tc = sr.getTestContext();				
				System.out.println("Passed tests in "+suiteName+" is "+tc.getPassedTests().getAllMethods().size());
				System.out.println("Failed tests in "+suiteName+" is "+tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped tests in "+suiteName+" is "+tc.getSkippedTests().getAllResults().size());
			}
		}
	}
}
