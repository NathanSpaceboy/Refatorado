package br.pucpr.mage;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class IndexBuffer {
    private int id;
    private int count;

    public IndexBuffer (int ... data){
        id = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, data, GL_STATIC_DRAW);
        glBindVertexArray(0);
    }

    public int getId(){
        return id;

    }

    public int getCount() {
        return count;
    }

    public IndexBuffer bind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
        return this;
    }

    public IndexBuffer unbind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        return this;
    }

    public IndexBuffer draw() {
        glDrawElements(GL_TRIANGLES, getCount(), GL_UNSIGNED_INT, 0);
        return this;
    }
}
