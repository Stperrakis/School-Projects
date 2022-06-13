clc
clear all
close all

number_of_variables = 4;
initial_Start_Point = [3 -1 0 1];

number_of_population = 5000;
number_of_generations = 100

Pm = 0.3;
Pbest =0.4;
stop = 10^(-6)
state = 1;
gen = 1;


%% create population
for i= 1 : number_of_population
    for j = 1: number_of_variables
        population(i,j) = initial_Start_Point(j);
    end
end


%% starting genetic algorithm

while(state||gen<=number_of_generations)
    fprintf("========GENERATION: %d==========\n",gen);
    %calculating fitness
    for i=1 : size(population,1)
        fitness_values(i,:) = [population(i,1),population(i,2),population(i,3),population(i,4),...
            func2(population(i,1:number_of_variables))];
        if fitness_values(i) <= stop
            state = 0 ;
            solution = [population(i,1),population(i,2),population(i,3),population(i,4),fitness_values(i)];
        end
        %calcBinary( population(i,1:number_of_variables) )
    end
    fitness_values_sorted=sortrows(fitness_values,5);
    new_population = mutation(fitness_values_sorted,Pm,state,number_of_variables);
    if new_population==0
        disp('no more childs')
        break;
    end
    x = fitness_values_sorted(1,:);
    fprintf("Best x1: %f Best x2: %f Best x3: %f Best x4: %f ===> Best f(x1,x2,x3,x4):%f\n",x(1),x(2),x(3),x(4),x(5));
    population_memoriae(gen).populations = population;
    population_memoriae(gen).gen = gen;
    population = [];
    fitness_values = [];
    population =new_population;
    gen = gen+1;
end
