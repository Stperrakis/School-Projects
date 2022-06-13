clc
clear all
close all
 %% 20 runs
 findgen = zeros(1,20);     
for run = 1:20
number_of_variables = 100;
initial_Start_Point = zeros(1,100);

number_of_population = 100;
number_of_generations = 50;

Pstart = 0.15;

Pc = 0.7;
Pm = 0.001;

stop = 100;
state = 1;
gen = 1;
% Initializing population
for i= 1 : number_of_population
    for j = 1: number_of_variables
        if j > 60
            %add extra variation in the initialization
            a = rand(1);
            if a>1-Pstart
                targ = 1;
            else
                targ = initial_Start_Point(j);
            end
        else
            targ = initial_Start_Point(j);
        end
        population(i,j) = targ;
    end
end

%% Generic Genetic Algorithm
    while(state&&gen<=number_of_generations)
        fprintf("========GENERATION: %d==========\n",gen);
        %calculating fitness
        for i=1 : size(population,1)
            fitness_values(i,:) = [population(i,1:number_of_variables)...
                func(population(i,1:number_of_variables))];
            if fitness_values(i) == stop
                state = 0 ;
                solution = [population(i,1),population(i,2),population(i,3),population(i,4),fitness_values(i)];
            end
        end
        fitness_values_sorted=sortrows(fitness_values,number_of_variables+1,'descend');
        [new_population,state] = mutation(fitness_values_sorted,Pc,state,number_of_variables,Pm);
        if new_population==0
            disp('no more childs')
            break;
        end
        
        x = fitness_values_sorted(1,101);
        if  x == 100
            if findgen(run)==0               
                findgen(run) = gen ;
            end
        end
        fprintf("Best current Gen f(x1,x2,x3,x4...x100):%f\n",x);
        population_memoriae(gen).populations = population;
        population_memoriae(gen).gen = gen;
        population = [];
        fitness_values = [];
        population =new_population;
        gen = gen+1;
    end
end
mean(findgen)
    
