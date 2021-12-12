# Moog One
A collection of tools and utilities for the [Moog One](https://www.moogmusic.com/products/moog-one) synthesizer operating on individual preset files.

## Background 
The individual presets (also known as patches) stored in Moog One synthesizer memory, and exported via USB, appear to be in their own proprietary format. Although transmission of Continuous Controller (CC) messages and System Exclusive (SYSEX) messages via MIDI is supported, the manufacturer selected to store all of its numerous settings in a dedicated file (with an extension of **m1p**). The contents of this file are in plain ASCII format and appears to resemble a Registry or Properties format listing out key/value pairs, delimited by space. 

You can see the example of this preset file [here](MoogOne/src/presets/WHERE%20IS%20THE%20BASS%20-LAZ.m1p).

## Intention
Since we can easily read, manipulate, and write out this file, it would be convenient to have a set of tools and utilities to programatically manipulate the parameter values and create a new or derivative preset. Here are some possible examples:

* Create a 'random' preset by selectively randomizing values of specified parameters
* Create a derivative preset by 'merging' two separate presets into one (by averaging the values of selected parameters)
* Create a 'morphing' preset by generating a modulation matrix with linear connections between source and destination values (could be two separate presets)
* Insert your own idea here

## Programming and Contribution 
The source in this repository is written in Java. The local execution of the program for novice users is still under development. But if you're a developer you can clone the repo and get going right away! Possible future interfaces may include Web (with the UI in HTML5/JavaScript). Meanwhile, your contribution towards the development of the project is welcome. In particular, it would be very helpful to collectively enumerate various undocumented attributes which we can then re-use, regardless of the programming language.

## Status
It's December of 2021 and this project is actively being developed. If six months have passed since this date and no commits have been made, it's possible for it to become stale. Otherwise, here's where we are:

#### Core Library
* Able to perform basic I/O on m1p files
* Created a basic hierarchy of Modules
* Defined Parameters which are backed by strongly typed pairs
* Able to randomize values (Double, Integer, and possible Strings)

#### Synth
* Randomized Oscillator Parameters (Wave Type, Angle, Octae, Pulse Width and Balance)
* Randomized Mixing Module Sources (Oscillators 1-3, RingMod and Noise)
* Randomized Filter routing with at least one Filter being selected
