package com.epam.rd.autocode.factory.plot;

import com.epam.rd.autocode.factory.plot.disney.ClassicDisney;
import com.epam.rd.autocode.factory.plot.disney.ContemporaryDisney;
import com.epam.rd.autocode.factory.plot.disney.MarvelDisney;

class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return new ClassicDisney(hero, beloved, villain);
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return new ContemporaryDisney(hero, epicCrisis, funnyFriend);
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return new MarvelDisney(heroes, epicCrisis, villain);
    }
}