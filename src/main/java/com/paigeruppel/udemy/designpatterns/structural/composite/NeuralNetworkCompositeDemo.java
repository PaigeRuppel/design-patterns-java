package com.paigeruppel.udemy.designpatterns.structural.composite;

import java.util.ArrayList;

public class NeuralNetworkCompositeDemo {
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        Neuron neuron2 = new Neuron();
        NeuronLayer layer = new NeuronLayer();
        NeuronLayer layer2 = new NeuronLayer();

        neuron.connectTo(neuron2);
//        These three connect methods are not supported
//        neuron.connectTo(layer);
//        layer.connectTo(neuron);
//        layer.connectTo(layer2);
    }
}

class Neuron {
    public ArrayList<Neuron> in, out;

    public void connectTo(Neuron other) {
        out.add(other);
        other.in.add(this);
    }
}


class NeuronLayer extends ArrayList<Neuron> {

}