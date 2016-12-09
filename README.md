# studies-multithreading-simulation

App which simulates flower lifetime (based on multithreading) and presents current state on some GUI.

Specification:
- There are 3 flowers and 3 flowerpots
- Flower can drink water from its flowerpot and from flowerpot of one neighbour - the access must be somehow synchronized
- Flowers drink water when they are under some dehydration level (specific for each flower)
- Flowers regularly dehydrate by some dehydration step (specific for each flower)
- Flowers drink water to maximum level (100) or as much as there is left in flowerpot
- Flowers always choose to drink from better filled pot.
- If the flower is on hydration=0 for n cycles - it dies.

- There is another thread for World - which restores water in each flowerpot with some specified interval.
- There is "Garneder" - basically a button to refill specified pot to full.
- There is some randomness..

As for GUI there may be another thread which collects data from all flowers and pots and then draws it to the GUI.
