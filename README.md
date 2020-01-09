# MobileComputing

Project created by:
Marcel Kanne    MSI-AS  294074,
Anatoly Kobasov MSI-AS  299764


We chose the MVP architectural design because it has the following advantages:

The logic (such as event handlers and user interface status) can be moved from the view to the presenter.
The user interface can be uniformly tested against the presenter because it describes the state of the user interface.
Since the user interface is isolated from the application logic, both can be developed independently.

But there are also some drawbacks to this approach:

It requires more effort.
The moderator can easily mutate into an unattainable "God class".
The application does not have a single MVP axis, but multiple axes: one for each screen/window/panel in the user interface. This can either simplify your architecture or terribly overcomplicate it.
