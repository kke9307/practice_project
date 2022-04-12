package com.menu.plant.model;

import java.io.Serializable;
import java.util.Map;

public class PlantVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String 적재년월일;
	private String 도입개체수량;
	private String 도입생체수량;
	private String 최종수정일시;
	private String 수집년월일;
	private String 한글종명;
	private String 전체도입학명;
	private String 도입번호;
	private String 도입생체단위명;
	private String 영문종명;
	private String 자원형태명;
	private String 도입경로명;
	private String 학명ID;
	private String 최초작성일시;
	private String 한글과명;
	private String 영문채집국가명;
	private String 영문과명;
	private String 영문속명;
	private String 정보제공기관명;
	private String 자원구분명;
	private String 연계기관명;
	private String 도입일시;
	private String 한글채집국가명;
	private String 한글속명;
	
	
	public String get적재년월일() {
		return 적재년월일;
	}
	public void set적재년월일(String 적재년월일) {
		this.적재년월일 = 적재년월일;
	}
	public String get도입개체수량() {
		return 도입개체수량;
	}
	public void set도입개체수량(String 도입개체수량) {
		this.도입개체수량 = 도입개체수량;
	}
	public String get최종수정일시() {
		return 최종수정일시;
	}
	public void set최종수정일시(String 최종수정일시) {
		this.최종수정일시 = 최종수정일시;
	}
	public String get수집년월일() {
		return 수집년월일;
	}
	public void set수집년월일(String 수집년월일) {
		this.수집년월일 = 수집년월일;
	}
	public String get한글종명() {
		return 한글종명;
	}
	public void set한글종명(String 한글종명) {
		this.한글종명 = 한글종명;
	}
	public String get전체도입학명() {
		return 전체도입학명;
	}
	public void set전체도입학명(String 전체도입학명) {
		this.전체도입학명 = 전체도입학명;
	}
	public String get도입번호() {
		return 도입번호;
	}
	public void set도입번호(String 도입번호) {
		this.도입번호 = 도입번호;
	}
	public String get도입생체단위명() {
		return 도입생체단위명;
	}
	public void set도입생체단위명(String 도입생체단위명) {
		this.도입생체단위명 = 도입생체단위명;
	}
	public String get영문종명() {
		return 영문종명;
	}
	public void set영문종명(String 영문종명) {
		this.영문종명 = 영문종명;
	}
	public String get자원형태명() {
		return 자원형태명;
	}
	public void set자원형태명(String 자원형태명) {
		this.자원형태명 = 자원형태명;
	}
	public String get도입경로명() {
		return 도입경로명;
	}
	public void set도입경로명(String 도입경로명) {
		this.도입경로명 = 도입경로명;
	}
	public String get학명ID() {
		return 학명ID;
	}
	public void set학명ID(String 학명id) {
		학명ID = 학명id;
	}
	public String get최초작성일시() {
		return 최초작성일시;
	}
	public void set최초작성일시(String 최초작성일시) {
		this.최초작성일시 = 최초작성일시;
	}
	public String get한글과명() {
		return 한글과명;
	}
	public void set한글과명(String 한글과명) {
		this.한글과명 = 한글과명;
	}
	public String get영문채집국가명() {
		return 영문채집국가명;
	}
	public void set영문채집국가명(String 영문채집국가명) {
		this.영문채집국가명 = 영문채집국가명;
	}
	public String get영문과명() {
		return 영문과명;
	}
	public void set영문과명(String 영문과명) {
		this.영문과명 = 영문과명;
	}
	public String get영문속명() {
		return 영문속명;
	}
	public void set영문속명(String 영문속명) {
		this.영문속명 = 영문속명;
	}
	public String get정보제공기관명() {
		return 정보제공기관명;
	}
	public void set정보제공기관명(String 정보제공기관명) {
		this.정보제공기관명 = 정보제공기관명;
	}
	public String get자원구분명() {
		return 자원구분명;
	}
	public void set자원구분명(String 자원구분명) {
		this.자원구분명 = 자원구분명;
	}
	public String get연계기관명() {
		return 연계기관명;
	}
	public void set연계기관명(String 연계기관명) {
		this.연계기관명 = 연계기관명;
	}
	public String get도입일시() {
		return 도입일시;
	}
	public void set도입일시(String 도입일시) {
		this.도입일시 = 도입일시;
	}
	public String get한글채집국가명() {
		return 한글채집국가명;
	}
	public void set한글채집국가명(String 한글채집국가명) {
		this.한글채집국가명 = 한글채집국가명;
	}
	public String get한글속명() {
		return 한글속명;
	}
	public void set한글속명(String 한글속명) {
		this.한글속명 = 한글속명;
	}
	
	public void setPlantMap(Map<String,String> map) {
		this.적재년월일 = 적재년월일;
		this.도입개체수량 = 도입개체수량;
		this.도입생체수량 = 도입생체수량;
		this.최종수정일시 = 최종수정일시;
		this.수집년월일 = 수집년월일;
		this.한글종명 = 한글종명;
		this.전체도입학명 = 전체도입학명;
		this.도입번호 = 도입번호;
		this.도입생체단위명 = 도입생체단위명;
		this.영문종명 = 영문종명;
		this.자원형태명 = 자원형태명;
		this.도입경로명 = 도입경로명;
		this.학명ID = 학명ID;
		this.최초작성일시 = 최초작성일시;
		this.한글과명 = 한글과명;
		this.영문채집국가명 = 영문채집국가명;
		this.영문과명 = 영문과명;
		this.영문속명 = 영문속명;
		this.정보제공기관명 = 정보제공기관명;
		this.자원구분명 = 자원구분명;
		this.연계기관명 = 연계기관명;
		this.도입일시 = 도입일시;
		this.한글채집국가명 = 한글채집국가명;
		this.한글속명 = 한글속명;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
