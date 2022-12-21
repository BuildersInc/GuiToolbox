# GuiToolbox

[![MavenDeploy](https://github.com/BuildersInc/GuiToolbox/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/BuildersInc/GuiToolbox/actions/workflows/maven-publish.yml)

This is a Tool in order to create a Minecraft Chest GUI.


## Import

Both changes have to go inside the pom.xml file of your project

```xml
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/BuildersInc/GuiToolbox</url>
    </repository>
```
```xml
    <dependency>
        <groupId>de.buildersinc</groupId>
        <artifactId>guitoolbox</artifactId>
        <version>1.0.0</version>
    </dependency>
```


## How work

Inside your plugin you need to create a new guiBuilder

```java

public final class Battlesystem extends JavaPlugin {

    private GuiBuilder guiBuilder;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.guiBuilder = new GuiBuilder(this, new GuiHandler());
    }
}
```

Inside the GUI Handler you need to implement the way an Input is handled

```java
public class GuiHandler extends EventInputHandler {


    @Override
    public void handleEvent(Event e) {
        InventoryClickEvent event = (InventoryClickEvent) e;
        System.out.println(event.getEventName());
        event.setCancelled(true);
    }
}
```

