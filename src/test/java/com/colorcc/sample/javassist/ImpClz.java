package com.colorcc.sample.javassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class ImpClz {
	int x, y;

	void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
		ClassPool cp = ClassPool.getDefault();
		CtClass cc = cp.get(ImpClz.class.getName());
		
		CtMethod m = cc.getDeclaredMethod("move");
		m.insertBefore("System.out.println($1 + \", \" + $2);");
		cc.writeFile("d:\\logs");
		
		byte[] bytecode = cc.toBytecode();
		System.out.println(new String(bytecode));
	}

}
