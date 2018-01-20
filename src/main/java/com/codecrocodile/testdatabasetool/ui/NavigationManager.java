package com.codecrocodile.testdatabasetool.ui;

import com.codecrocodile.testdatabasetool.config.SpringConfig;
import javafx.scene.Node;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Observable;
import java.util.Stack;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class NavigationManager extends Observable {

	public static final Logger log = LogManager.getLogger(NavigationManager.class);

	public enum UpdateEvent {
		PAGE_CHANGE
	}

	public enum HistoryAction {
		NONE, 
		CLEAR_HISTORY,
		CLEAR_FORWARD_HISTORY
	}

	private ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

	private Start start;

	private Stack<Page> backStack = new Stack<>();

	private Stack<Page> forwardStack = new Stack<>();


	public NavigationManager(Start start) {
		this.start = start;
	}

	public Page requestPageChange(String pageName, HistoryAction historyAction, boolean showTransiton) {

		switch (historyAction) {
		case CLEAR_HISTORY: {
			this.backStack.clear();
			this.forwardStack.clear();

			break;
		}
		case CLEAR_FORWARD_HISTORY: {
			this.forwardStack.clear();

			break;
		}
		default:
			break;
		}

		log.info("request for " + pageName);

		for (String s : ctx.getBeanDefinitionNames()) {

			System.out.println(s);
		}


		Page pageToDisplay = ctx.getBean(pageName, Page.class);
		pageToDisplay.setNavigationManager(this);

		log.info("init = " + pageToDisplay);

		try {
			Node node = pageToDisplay.getPageView();
			start.setView(node, showTransiton);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.backStack.push(pageToDisplay);

		this.setChanged();
		this.notifyObservers(UpdateEvent.PAGE_CHANGE);

		return pageToDisplay;
	}

	public boolean canGoBack() {
		return backStack.size() > 1;
	}

	public boolean goBack() {
		if (backStack.size() > 1) {
			Page popped = backStack.pop();
			forwardStack.push(popped);

			try {
				Page peek = backStack.peek();
				peek.refreshView();
				start.setView(peek.getPageView(), true);
			} catch (Exception e) {
				e.printStackTrace();
			}

			this.setChanged();
			this.notifyObservers(UpdateEvent.PAGE_CHANGE);

			return true;
		} else {
			return false;
		}
	}

	public boolean canGoForward() {
		return forwardStack.size() > 0;
	}

	public boolean goForward() {
		if (forwardStack.size() > 0) {
			Page popped = forwardStack.pop();
			backStack.push(popped);

			try {
				start.setView(backStack.peek().getPageView(), true);
			} catch (Exception e) {
				e.printStackTrace();
			}

			this.setChanged();
			this.notifyObservers(UpdateEvent.PAGE_CHANGE);

			return true;
		} else {
			return false;
		}
	}

}
