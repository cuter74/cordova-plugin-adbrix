//
//  Adbrix.m
//  DreamDNA
//
//  Created by mscbrain on 2016. 10. 6..
//
//
#import "Adbrix.h"
#import <Cordova/CDVPlugin.h>
#import <AdBrix/AdBrix.h>

@implementation Adbrix

-(void) retention :(CDVInvokedUrlCommand*)command
{
    NSString* menuName  = [command.arguments objectAtIndex:0];

    NSLog(@"menuName============!!==%@", menuName);
    [AdBrix retention:menuName];
    
}

@end
