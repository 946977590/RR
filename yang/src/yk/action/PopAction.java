package yk.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yk.entity.Pop;



public class PopAction extends ActionSupport implements ModelDriven<Pop>{

	private Pop pop=new Pop();
	
	
	public Pop getPop() {
		return pop;
	}


	public void setPop(Pop pop) {
		this.pop = pop;
	}


	@Override
	public Pop getModel() {
		// TODO Auto-generated method stub
		return pop;
	}

}
