package kadai;

//国情報クラス//

public class Country {

	//国名
	private String name;

	//都市名
	private String city;

	//気候
	private String crimate;

	//国民性
	private String nationalmentality;

	//特徴
	private String feature;

	//移住に当たる注意点
	private String notice;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCrimate() {
		return crimate;
	}

	public void setCrimate(String crimate) {
		this.crimate = crimate;
	}

	public String getNationalmentality() {
		return nationalmentality;
	}

	public void setNationalmentality(String nationalmentality) {
		this.nationalmentality = nationalmentality;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", city=" + city + ", crimate=" + crimate + ", nationalmentality="
				+ nationalmentality + ", feature=" + feature + ", notice=" + notice + "]";
	}
}
