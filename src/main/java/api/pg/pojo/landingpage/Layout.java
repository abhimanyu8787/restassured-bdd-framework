package api.pg.pojo.landingpage;

public class Layout {
	
	private Topbar topbar;
	private Header header;
	private Body body;
	private Footer footer;
	private Statistics statistics;
	private RecentlyJoinedAlumni recentlyJoinedAlumni;
	private Benefits benefits;
	private Testimonials testimonials;
	private Faq faq;
	public Topbar getTopbar() {
		return topbar;
	}
	public void setTopbar(Topbar topbar) {
		this.topbar = topbar;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public Footer getFooter() {
		return footer;
	}
	public void setFooter(Footer footer) {
		this.footer = footer;
	}
	public Statistics getStatistics() {
		return statistics;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	public RecentlyJoinedAlumni getRecentlyJoinedAlumni() {
		return recentlyJoinedAlumni;
	}
	public void setRecentlyJoinedAlumni(RecentlyJoinedAlumni recentlyJoinedAlumni) {
		this.recentlyJoinedAlumni = recentlyJoinedAlumni;
	}
	public Benefits getBenefits() {
		return benefits;
	}
	public void setBenefits(Benefits benefits) {
		this.benefits = benefits;
	}
	public Testimonials getTestimonials() {
		return testimonials;
	}
	public void setTestimonials(Testimonials testimonials) {
		this.testimonials = testimonials;
	}
	public Faq getFaq() {
		return faq;
	}
	public void setFaq(Faq faq) {
		this.faq = faq;
	}
	
}
