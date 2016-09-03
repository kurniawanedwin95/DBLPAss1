package edu.unsw.comp9321;

public class DBLPBean{
	
	private ArticleBean articleBean;
	private BookBean bookBean;
	private InproceedingsBean inproceedingsBean;
	private ProceedingsBean proceedingsBean;
	private IncollectionBean incollectionBean;
	private MastersThesisBean mastersThesisBean;
	private PHDThesisBean phdThesisBean;
	private WWWBean wwwBean;

	public DBLPBean() {
	}
	
	public DBLPBean(ArticleBean articleBean, BookBean bookBean, 
			InproceedingsBean inproceedingsBean, ProceedingsBean proceedingsBean, 
			IncollectionBean incollectionBean, MastersThesisBean mastersThesisBean,
			PHDThesisBean phdThesisBean, WWWBean wwwBean) {
		super();
		this.setArticleBean(articleBean);
		this.setBookBean(bookBean);
		this.setIncollectionBean(incollectionBean);
		this.setInproceedingsBean(inproceedingsBean);
		this.setProceedingsBean(proceedingsBean);
		this.setMastersThesisBean(mastersThesisBean);
		this.setPhdThesisBean(phdThesisBean);
		this.setWwwBean(wwwBean);
		
	}

	public ArticleBean getArticleBean() {
		return articleBean;
	}

	public void setArticleBean(ArticleBean articleBean) {
		this.articleBean = articleBean;
	}

	public BookBean getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	public InproceedingsBean getInproceedingsBean() {
		return inproceedingsBean;
	}

	public void setInproceedingsBean(InproceedingsBean inproceedingsBean) {
		this.inproceedingsBean = inproceedingsBean;
	}

	public ProceedingsBean getProceedingsBean() {
		return proceedingsBean;
	}

	public void setProceedingsBean(ProceedingsBean proceedingsBean) {
		this.proceedingsBean = proceedingsBean;
	}

	public IncollectionBean getIncollectionBean() {
		return incollectionBean;
	}

	public void setIncollectionBean(IncollectionBean incollectionBean) {
		this.incollectionBean = incollectionBean;
	}

	public MastersThesisBean getMastersThesisBean() {
		return mastersThesisBean;
	}

	public void setMastersThesisBean(MastersThesisBean mastersThesisBean) {
		this.mastersThesisBean = mastersThesisBean;
	}

	public PHDThesisBean getPhdThesisBean() {
		return phdThesisBean;
	}

	public void setPhdThesisBean(PHDThesisBean phdThesisBean) {
		this.phdThesisBean = phdThesisBean;
	}

	public WWWBean getWwwBean() {
		return wwwBean;
	}

	public void setWwwBean(WWWBean wwwBean) {
		this.wwwBean = wwwBean;
	}
	
}
