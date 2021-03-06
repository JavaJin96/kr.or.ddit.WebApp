package kr.or.ddit.enumpkg;

public enum BrowserInfo {
	//final String EDG = "EDG";
	//final BrowserInfo EDG = new BrowserInfo();
	EDG("엣지"), CHROME("크롬"), SAFARI("사파리"), OTHER("기타");
	
	
	private BrowserInfo(String browserName) {
		this.browserName = browserName;
	}

	private String browserName;
	
	public String getBrowserName() {
		return browserName;
	}
	
	public static String findBrowser(String userAgent) {
		userAgent = userAgent.toUpperCase();
		String res = "기타";
		
		BrowserInfo info = BrowserInfo.OTHER;

		for (BrowserInfo tmp : BrowserInfo.values()){
			if(userAgent.contains(tmp.name())){
				info = tmp;
				break;
			}
		}
		
		res = info.getBrowserName();
		return res;
	}
	
}
